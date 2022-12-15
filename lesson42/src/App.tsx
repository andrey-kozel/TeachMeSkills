import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import WelcomePage from './pages/WelcomePage';
import UsersPage from './pages/UsersPage';
import LoginPage from './pages/LoginPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={'/'} element={<WelcomePage />} />
        <Route path={'/login'} element={<LoginPage />} />
        <Route path={'/users'} element={<UsersPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
