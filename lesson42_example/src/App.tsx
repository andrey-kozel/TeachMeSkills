import React from 'react';
import { Route, Routes } from 'react-router-dom';
import WelcomePage from './pages/WelcomePage/WelcomePage';
import UsersPage from './pages/UsersPage/UsersPage';
import UserPage from './pages/UserPage/UserPage';

function App() {
  return (
    <Routes>
      <Route path={'/'} element={<WelcomePage />} />
      <Route path={'/users'} element={<UsersPage />} />
      <Route path={'/users/:id'} element={<UserPage />} />
    </Routes>
  );
}

export default App;
