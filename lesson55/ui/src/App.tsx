import React, { useEffect, useState } from 'react';
import imageService from './ImageService';

function App() {

  const [image, setImage] = useState('');

  useEffect(() => {
    imageService.downloadImage()
      .then(response => {
        setImage(response);
      });
  }, []);

  return (
    <div className="App">
      <img src={`data:image/png;base64,${image}`} />
    </div>
  );
}

export default App;
