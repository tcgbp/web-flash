import request from '@/utils/request'
export default {
    getList:function(params) {
        return request({
            url: '/classGrade/list',
            method: 'get',
            params
        })
    },
    add:function(params) {
        return request({
            url: '/classGrade',
            method: 'post',
            params
        })
    },
    update:function(params) {
        return request({
            url: '/classGrade',
            method: 'PUT',
            params
        })
    },
    remove:function(id) {
        return request({
            url: '/classGrade',
            method: 'delete',
            params: {
                id: id
            }
        })
    }
}
