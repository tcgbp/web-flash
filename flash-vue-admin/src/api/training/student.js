import request from '@/utils/request'
export default {
    getList:function(params) {
        return request({
            url: '/student/list',
            method: 'get',
            params
        })
    },
    add:function(params) {
        return request({
            url: '/student',
            method: 'post',
            params
        })
    },
    update:function(params) {
        return request({
            url: '/student',
            method: 'PUT',
            params
        })
    },
    remove:function(id) {
        return request({
            url: '/student',
            method: 'delete',
            params: {
                id: id
            }
        })
    }
}
