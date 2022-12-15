import { User } from '../model/User';
import axios from 'axios';

class UserService {

  async getUsers(): Promise<Array<User>> {
    const response = await axios.get<Array<User>>('http://localhost:8080/api/v1/users');
    return response.data;
  }

  async saveUser(user: any): Promise<void> {
    await axios.post<Array<User>>('http://localhost:8080/api/v1/users', user);
  }

}

export default new UserService();
