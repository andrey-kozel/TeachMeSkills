import axios from 'axios';
import { Buffer } from 'buffer';

class ImageService {

  async downloadImage(): Promise<any> {
    const response = await axios.get<any>('https://localhost:8080/api/v1/files', {
      responseType: 'arraybuffer'
    });
    return Buffer.from(response.data, 'binary').toString('base64');
  }

}

export default new ImageService();
