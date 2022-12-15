import React, { useEffect, useState } from 'react';
import { Box, Modal, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import { User } from '../model/User';
import UserService from '../service/UserService';
import Button from '@mui/material/Button';

function UsersPage() {
  const [users, setUsers] = useState<Array<User>>([]);
  const [error, setError] = useState<string>('');
  const [open, setOpen] = useState<boolean>(false);

  useEffect(() => {
    UserService.getUsers()
      .then(users => setUsers(users))
      .catch(err => setError(err.message));
  }, []);

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
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box>

        </Box>
      </Modal>
    </>
  );
}

export default UsersPage;
