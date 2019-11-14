<template>
  <div>
    Admin Page
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
export default class Admin extends Vue {
  
}
</script>