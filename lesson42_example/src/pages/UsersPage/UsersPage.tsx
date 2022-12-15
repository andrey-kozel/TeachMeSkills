import React, { useEffect, useState } from 'react';
import UserService from '../../services/UserSevice';
import { User } from '../../model/User';
import {
  Box, Button,
  Card,
  Modal,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TextField
} from '@mui/material';

const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

const UsersPage = () => {
  const [firstName, setFirstName] = useState<string>('');
  const [lastName, setLastName] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [open, setOpen] = useState<boolean>(false);

  const [users, setUsers] = useState<Array<User>>([]);
  const [error, setError] = useState<string>('');

  useEffect(() => {
    UserService.getUsers()
      .then(response => setUsers(response))
      .catch(error => setError(error.message));
  }, []);

  const saveUser = () => {
    UserService.saveUser({ firstName, lastName, password })
      .then(() => UserService.getUsers()
        .then(users => {
          setUsers(users);
          setOpen(false);
        })
        .catch(err => setError(err.message)));
  };

  return (
    <div>
      {error}
      <Button onClick={() => setOpen(true)}>Open modal</Button>
      <Card style={{ width: 500 }}>
        <TableContainer>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>First name</TableCell>
                <TableCell align="right">LastName</TableCell>
                <TableCell align="right">Password</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {users.map((user) => (
                <TableRow
                  key={user.lastName}
                  sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                >
                  <TableCell component="th" scope="row">
                    {user.firstName}
                  </TableCell>
                  <TableCell align="right">
                    {user.lastName}
                  </TableCell>
                  <TableCell align="right">
                    {user.password}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Card>
      <Modal
        open={open}
        onClose={() => setOpen(false)}
      >
        <Box sx={style}>
          <TextField
            required
            fullWidth
            label="First name"
            name="firstName"
            value={firstName}
            onChange={(e: any) => setFirstName(e.target.value)}
          />
          <TextField
            required
            fullWidth
            label="Last name"
            name="lastName"
            value={lastName}
            onChange={(e: any) => setLastName(e.target.value)}
          />
          <TextField
            required
            fullWidth
            label="Password"
            name="password"
            value={password}
            onChange={(e: any) => setPassword(e.target.value)}
          />

          <Button variant="contained" onClick={saveUser}>Save</Button>
        </Box>
      </Modal>
    </div>
  );
};

export default UsersPage;
