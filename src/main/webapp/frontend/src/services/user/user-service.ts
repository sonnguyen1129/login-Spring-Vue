import Vue from 'vue';
import { AxiosPromise } from 'axios';
import { UserDto } from '@/models/user/UserDto';  // @ là ký tự để trỏ đến root path (folder src)

class UserService extends Vue {
  private ROOT_API = 'http://localhost:8090';  // Root api 

  public getAll(): AxiosPromise<UserDto[]> {
    return Vue.axios.get<UserDto[]>(this.ROOT_API + '/user/all');
  }

  public login(userDto: UserDto): AxiosPromise<UserDto> {
    return Vue.axios.post<UserDto>(this.ROOT_API + '/login', userDto);
  }
}
export const userService = new UserService();