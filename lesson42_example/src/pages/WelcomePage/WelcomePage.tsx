import React from 'react';
import { Link } from 'react-router-dom';

const WelcomePage = () => {
  return (
    <div>
      <Link to={'/users'}>Go to users</Link>
    </div>
  );
};

export default WelcomePage;
