<template>
  <div class="login-container" style="background-image: url(./img/bg.jpg)">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
      auto-complete="on"
      label-position="left"
    >
      <div class="title-container">
        <h3 class="title">{{ $t("login.title") }}</h3>
        <lang-select class="set-language" />
      </div>
      <el-tabs v-model="qrcode.activeName" type="border-card" @tab-click="changeLoginType">
        <el-tab-pane label="账号密码登录" name="first">
          <el-form-item prop="username">
            <span class="svg-container">
              <svg-icon icon-class="user" />
            </span>
            <el-input
              v-model="loginForm.username"
              :placeholder="$t('login.username')"
              name="username"
              type="text"
              auto-complete="on"
            />
          </el-form-item>

          <el-form-item prop="password">
            <span class="svg-container">
              <svg-icon icon-class="password" />
            </span>
            <el-input
              :type="pwdType"
              v-model="loginForm.password"
              :placeholder="$t('login.password')"
              name="password"
              auto-complete="on"
              @keyup.enter.native="handleLogin"
            />
            <span class="show-pwd" @click="showPwd">
              <svg-icon icon-class="eye" />
            </span>
          </el-form-item>

          <el-button
            :loading="loading"
            type="primary"
            style="width: 100%; margin-bottom: 30px"
            @click.native.prevent="handleLogin"> {{ $t("login.logIn") }} </el-button>

          <div style="position: relative">
            <div class="tips">
              <span>{{ $t("login.username") }} : admin</span>
              <span>{{ $t("login.password") }} : admin</span>
            </div>
            <div class="tips">
              <span style="margin-right: 18px">{{ $t("login.username") }} : director</span>
              <span>{{ $t("login.password") }} : admin</span>
            </div>
            <div class="tips">
              <span style="margin-right: 18px">{{ $t("login.username") }} : teacher</span>
              <span>{{ $t("login.password") }} : admin</span>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </el-form>
  </div>
</template>

<script src="./login.js"></script>
<style rel="stylesheet/scss" lang="scss" src="./login.scss"></style>
