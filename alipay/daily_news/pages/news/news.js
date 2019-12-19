Page({
  data: {},
  onLoad(op) {
    console.log(op);
    this.setData(
      {
        "url":op.url
      }
    );
  },
});
