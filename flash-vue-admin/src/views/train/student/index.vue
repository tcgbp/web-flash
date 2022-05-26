<template>
    <div class="app-container">
        <div class="block">
            <el-row  :gutter="20">
                <el-col :span="4">
                    <el-input v-model="listQuery.id" size="mini" placeholder="请输入id"></el-input>
                </el-col>
                <el-col :span="6">
                    <el-button type="success" size="mini" icon="el-icon-search" @click.native="search">{{ $t('button.search') }}</el-button>
                    <el-button type="primary" size="mini" icon="el-icon-refresh" @click.native="reset">{{ $t('button.reset') }}</el-button>
                </el-col>
            </el-row>
            <br>
            <el-row>
                <el-col :span="24">
                    <el-button type="success" size="mini"  icon="el-icon-plus" @click.native="add" v-permission="['/student/add']">{{ $t('button.add') }}</el-button>
                    <el-button type="primary" size="mini"  icon="el-icon-edit" @click.native="edit" v-permission="['/student/update']">{{ $t('button.edit') }}</el-button>
                    <el-button type="danger" size="mini"  icon="el-icon-delete" @click.native="remove" v-permission="['/student/delete']">{{ $t('button.delete') }}</el-button>
                </el-col>
            </el-row>
        </div>


        <el-table :data="list" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row
                  @current-change="handleCurrentChange">
            <el-table-column label="头像">
                <template slot-scope="scope">
                    {{scope.row.avatar}}
                </template>
            </el-table-column>
            <el-table-column label="账户">
                <template slot-scope="scope">
                    {{scope.row.account}}
                </template>
            </el-table-column>
            <el-table-column label="密码">
                <template slot-scope="scope">
                    {{scope.row.password}}
                </template>
            </el-table-column>
            <el-table-column label="密码盐">
                <template slot-scope="scope">
                    {{scope.row.salt}}
                </template>
            </el-table-column>
            <el-table-column label="姓名">
                <template slot-scope="scope">
                    {{scope.row.name}}
                </template>
            </el-table-column>
            <el-table-column label="生日">
                <template slot-scope="scope">
                    {{scope.row.birthday}}
                </template>
            </el-table-column>
            <el-table-column label="性别:1:男,2:女">
                <template slot-scope="scope">
                    {{scope.row.sex}}
                </template>
            </el-table-column>
            <el-table-column label="email">
                <template slot-scope="scope">
                    {{scope.row.email}}
                </template>
            </el-table-column>
            <el-table-column label="手机号">
                <template slot-scope="scope">
                    {{scope.row.phone}}
                </template>
            </el-table-column>
            <el-table-column label="角色id列表，以逗号分隔">
                <template slot-scope="scope">
                    {{scope.row.roleid}}
                </template>
            </el-table-column>
            <el-table-column label="部门id">
                <template slot-scope="scope">
                    {{scope.row.deptid}}
                </template>
            </el-table-column>
            <el-table-column label="状态1:启用,2:禁用">
                <template slot-scope="scope">
                    {{scope.row.status}}
                </template>
            </el-table-column>
            <el-table-column label="版本">
                <template slot-scope="scope">
                    {{scope.row.version}}
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" size="mini" icon="el-icon-edit" @click.native="editItem(scope.row)" v-permission="['/student/update']">{{ $t('button.edit') }}</el-button>
                    <el-button type="text" size="mini" icon="el-icon-delete" @click.native="removeItem(scope.row)" v-permission="['/student/delete']">{{ $t('button.delete') }}</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="total, sizes, prev, pager, next, jumper"
                :page-sizes="[10, 20, 50, 100,500]"
                :page-size="listQuery.limit"
                :total="total"
                @size-change="changeSize"
                @current-change="fetchPage"
                @prev-click="fetchPrev"
                @next-click="fetchNext">
        </el-pagination>

        <el-dialog
                :title="formTitle"
                :visible.sync="formVisible"
                width="70%">
            <el-form ref="form" :model="form" :rules="rules" label-width="120px">
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="头像"  >
                            <el-input v-model="form.avatar" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="账户"  >
                            <el-input v-model="form.account" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="密码"  >
                            <el-input v-model="form.password" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="密码盐"  >
                            <el-input v-model="form.salt" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="姓名"  >
                            <el-input v-model="form.name" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="生日"  >
                            <el-input v-model="form.birthday" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="性别:1:男,2:女"  >
                            <el-input v-model="form.sex" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="email"  >
                            <el-input v-model="form.email" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="手机号"  >
                            <el-input v-model="form.phone" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="角色id列表，以逗号分隔"  >
                            <el-input v-model="form.roleid" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="部门id"  >
                            <el-input v-model="form.deptid" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="状态1:启用,2:禁用"  >
                            <el-input v-model="form.status" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="版本"  >
                            <el-input v-model="form.version" minlength=1></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-form-item>
                    <el-button type="primary" @click="save">{{ $t('button.submit') }}</el-button>
                    <el-button @click.native="formVisible = false">{{ $t('button.cancel') }}</el-button>
                </el-form-item>

            </el-form>
        </el-dialog>
    </div>
</template>

<script src="./student.js"></script>


<style rel="stylesheet/scss" lang="scss" scoped>
    @import "src/styles/common.scss";
</style>

