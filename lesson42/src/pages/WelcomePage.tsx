import React from 'react';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

function WelcomePage() {
  return (
    <div>
      <Button component={Link} to={'/users'} variant="contained">Go to users</Button>
    </div>
  );
}

export default WelcomePage;
