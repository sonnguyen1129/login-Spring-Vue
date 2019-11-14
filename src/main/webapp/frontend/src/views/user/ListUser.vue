<template>
  <div>
    <b-row>
      <b-col offset="3" xl="6">
        <b-table class="transition"
          id="table-transition-example"
          :items="listUser"
          :fields="fieldsTable"
          striped
          small
          bordered
          responsive
          sticky-header
          primary-key="id"></b-table>
      </b-col>
    </b-row>
  </div>
</template>

<style lang="scss" scoped>

</style>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { UserDto } from "@/models/user/UserDto.ts";
import { userService } from "@/services/user/user-service.ts";
import { AxiosResponse } from "axios";

@Component({
  components: {
  }
})
export default class listUser extends Vue {
  private listUser: UserDto[] = [];

  private fieldsTable: any =[
          { key: 'id', sortable: true },
          { key: 'username', sortable: true },
          { key: 'pazzword', sortable: true }
        ]
  
  private mounted() {
      userService.getAll()
      .then((res: AxiosResponse) => {
        this.listUser = res.data;
      })
  }
}
</script>