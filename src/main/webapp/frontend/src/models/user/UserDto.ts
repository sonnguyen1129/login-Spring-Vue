export class UserDto {
    public id?: string;
    public username?: string;
    public password?: string;
    public phone?: string;
    public role?: string;
  
    constructor(init?: Partial<UserDto>) {
      Object.assign(this, init);
    }
  }