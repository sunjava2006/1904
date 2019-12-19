Page({
  data: {
     typelist:[{title:"头条",type:"top"},
               {title:"社会",type:"shehui"},
               {title:"国内",type:"guonei"},
               {title:"国际",type:"guoji"},
               {title:"娱乐",type:"yule"},
               {title:"体育",type:"tiyu"},
               {title:"军事",type:"junshi"},
               {title:"科技",type:"keji"},
               {title:"财经",type:"caijing"},
               {title:"时尚",type:"shishang"}],
     type:0,
     newsList:[]
  },

  getList(type){
    my.request({
        url: 'http://v.juhe.cn/toutiao/index?type='+type+'&key=082153265794dc7a4bdb119e272319ee',
        success: (result) => {
          var newsList = result.data.result.data;
          this.setData(
              {
                  "newsList":newsList
              }
          );
        }
      });
  },

  onLoad() {
      this.getList(this.data.typelist[0].type);
  },
  selected(e){
      var id = e.currentTarget.id;
      this.getList(this.data.typelist[id].type);
      this.setData({
          type:id
      });
  },
  slide(e){
      var id = e.detail.current;
      this.getList(this.data.typelist[id].type);
       this.setData({
          type:id
      });
  },
  show(e){
      var url = this.data.newsList[e.currentTarget.id].url;
      console.log(url);
      my.navigateTo({
          "url":"/pages/news/news?url="+url
      });
  }
});
