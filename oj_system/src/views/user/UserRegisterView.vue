<template>
  <a-form
    ref="formRef"
    style="max-width: 480px; margin: 0 auto"
    :rules="rules"
    :model="form"
    :style="{ width: '600px' }"
    @submit="handleSubmit"
  >
    <a-form-item field="name" label="账号" validate-trigger="blur">
      <a-input v-model="form.name" placeholder="请输入账号" />
    </a-form-item>
    <a-form-item field="password" label="密码" validate-trigger="blur">
      <a-input-password v-model="form.password" placeholder="请输入密码" />
    </a-form-item>
    <a-form-item field="password2" label="确认密码" validate-trigger="blur">
      <a-input-password v-model="form.password2" placeholder="请确认你的密码" />
    </a-form-item>
    <a-form-item>
      <a-space>
        <a-button type="primary" style="width: 120px" html-type="submit"
          >提交
        </a-button>
      </a-space>
    </a-form-item>
  </a-form>
  {{ form }}
</template>
<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const form = reactive({
  name: "",
  password: "",
  password2: "",
});

const rules = {
  name: [
    {
      required: true,
      message: "name is required",
    },
  ],
  password: [
    {
      required: true,
      message: "password is required",
    },
  ],
  password2: [
    {
      required: true,
      message: "password is required",
    },
    {
      validator: (value, cb) => {
        if (value !== form.password) {
          cb("two passwords do not match");
        } else {
          cb();
        }
      },
    },
  ],
};

const router = useRouter();
const store = useStore();
const handleSubmit = async ({ values, errors }) => {
  console.log("values:", values, "\nerrors:", errors);
  const res = await UserControllerService.userRegisterUsingPost(form);
  // //登录成功,则跳转到主页
  // if (res.code === 0) {
  //   await store.dispatch("user/getLoginUser");
  //   router.push({
  //     path: "/",
  //     replace: true,
  //   });
  //   store.dispatch("user/getLoginUser");
  // } else {
  //   message.error("登录失败," + res.message);
  // }
};
</script>
