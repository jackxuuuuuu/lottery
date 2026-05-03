const app = getApp()

Page({
  data: {
    loading: false,
    result: null,
    errorMsg: ''
  },

  draw() {
    if (this.data.loading) return

    this.setData({ loading: true, result: null, errorMsg: '' })

    wx.request({
      url: `${app.globalData.apiBaseUrl}/api/lottery/draw`,
      method: 'GET',
      success: (res) => {
        const json = res.data
        if (json.code === 0) {
          this.setData({ result: json.data })
        } else {
          this.setData({ errorMsg: json.msg || '抽奖失败，请重试' })
        }
      },
      fail: () => {
        this.setData({ errorMsg: '网络错误，请检查网络后重试' })
      },
      complete: () => {
        this.setData({ loading: false })
      }
    })
  }
})
