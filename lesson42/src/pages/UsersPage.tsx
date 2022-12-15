import React, { useEffect, useState } from 'react';
import {
  Box,
  Modal,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TextField
} from '@mui/material';
import { User } from '../model/User';
import UserService from '../service/UserService';
import Button from '@mui/material/Button';

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

function UsersPage() {
  const [firstName, setFirstName] = useState<string>('');
  const [lastName, setLastName] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const [users, setUsers] = useState<Array<User>>([]);
  const [error, setError] = useState<string>('');
  const [open, setOpen] = useState<boolean>(false);

  useEffect(() => {
    UserService.getUsers()
      .then(users => setUsers(users))
      .catch(err => setError(err.message));
  }, []);

  const saveUser = () => {
    UserService.saveUser({ firstName, lastName, password })
      .then(() => UserService.getUsers()
        .then(users => setUsers(users))
        .catch(err => setError(err.message)));
  };

  return (
    <>
      {error}
      <Button onClick={() => setOpen(true)}>Open modal</Button>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Id</TableCell>
              <TableCell align="right">First name</TableCell>
              <TableCell align="right">Last name</TableCell>
              <TableCell align="right">Password</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {users.map((row) => (
              <TableRow
                key={row.id}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.id}
                </TableCell>
                <TableCell align="right">{row.firstName}</TableCell>
                <TableCell align="right">{row.lastName}</TableCell>
                <TableCell align="right">{row.password}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
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
    </>
  );
}

export default UsersPage;
