import React, { useCallback, useEffect, useRef, useState } from 'react';
import imageService from './ImageService';
import { Box, Button, TextField } from '@mui/material';

function App() {
  const [image, setImage] = useState('');

  const fileInput = useRef<HTMLInputElement | null>(null);
  const [name, setName] = useState('');
  const [price, setPrice] = useState(0);

  useEffect(() => {
    imageService.downloadImage()
      .then(response => {
        setImage(response);
      });
  }, []);

  const uploadImage = () => {
    imageService.uploadFile({name, price, file: fileInput?.current?.files && fileInput?.current?.files[0]})
      .then(response => {
        setImage(response);
      })
  };

  return (
    <div className="App">
      <img src={`data:image/png;base64,${image}`} />
      <Box
        component="form"
        sx={{
          '& > :not(style)': { m: 1, width: '25ch' }
        }}
        noValidate
        autoComplete="off"
      >
        <TextField label="Name"
                   value={name}
                   onChange={e => setName(e.target.value)} />
        <TextField label="Price"
                   type={'number'}
                   value={price}
                   onChange={e => setPrice(Number(e.target.value))} />
        <Button
          variant="contained"
          component="label"
        >
          Upload File
          <input
            ref={fileInput}
            type="file"
            hidden
          />
        </Button>
        <Button
          variant="contained"
          component="label"
          onClick={uploadImage}
        >
          Save
        </Button>
      </Box>
    </div>
  );
}

export default App;
