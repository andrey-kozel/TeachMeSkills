import axios from 'axios';
import { Buffer } from 'buffer';

class ImageService {

  async downloadImage(): Promise<any> {
    const response = await axios.get<any>('https://localhost:8080/api/v1/files', {
      responseType: 'arraybuffer'
    });
    return Buffer.from(response.data, 'binary').toString('base64');
  }

  async uploadFile({name, price, file}: any): Promise<any> {
    const formData = new FormData();
    formData.append('name', name);
    formData.append('price', price);
    formData.append('file', file, file.name);
    const response = await axios.post<any>('https://localhost:8080/api/v1/files', formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
    return Buffer.from(response.data, 'binary').toString('base64');
  }


}

export default new ImageService();
