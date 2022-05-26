import request from '@/utils/request'
export default {
    getList:function(params) {
        return request({
            url: '/class/list',
            method: 'get',
            params
        })
    },
    add:function(params) {
        return request({
            url: '/class',
            method: 'post',
            params
        })
    },
    update:function(params) {
        return request({
            url: '/class',
            method: 'PUT',
            params
        })
    },
    remove:function(id) {
        return request({
            url: '/class',
            method: 'delete',
            params: {
                id: id
            }
        })
    }
}
