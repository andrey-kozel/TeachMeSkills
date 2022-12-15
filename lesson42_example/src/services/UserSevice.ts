import axios from 'axios';
import { User } from '../model/User';

class UserService {

  async getUsers(): Promise<Array<User>> {
    const response = await axios.get<Array<User>>('http://localhost:8080/api/v1/users');
    return response.data;
  }

  async saveUser(user: User): Promise<void> {
    await axios.post('http://localhost:8080/api/v1/users', user);
  }

}

export default new UserService();
