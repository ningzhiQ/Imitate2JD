package com.jd.myjd.imitate2jd.bean;

import java.util.List;

public class AdvertisingBean {
    private String msg;
    private String code;
    private TuijianBean tuijian;
    private MiaoshaBean miaosha;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "AdvertisingBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", tuijian=" + tuijian +
                ", miaosha=" + miaosha +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TuijianBean getTuijian() {
        return tuijian;
    }

    public void setTuijian(TuijianBean tuijian) {
        this.tuijian = tuijian;
    }

    public MiaoshaBean getMiaosha() {
        return miaosha;
    }

    public void setMiaosha(MiaoshaBean miaosha) {
        this.miaosha = miaosha;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TuijianBean {

        private String name;
        private List<ListBean> list;

        @Override
        public String toString() {
            return "TuijianBean{" +
                    "name='" + name + '\'' +
                    ", list=" + list +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 11800
             * createtime : 2017-10-10T17:33:37
             * detailUrl : https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg
             * itemtype : 0
             * pid : 57
             * price : 5199
             * pscid : 40
             * salenum : 4343
             * sellerid : 1
             * subhead : 【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统
             * title : 小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银

             */

            private String bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private String itemtype;
            private String pid;
            private String price;
            private String pscid;
            private String salenum;
            private String sellerid;
            private String subhead;
            private String title;

            @Override
            public String toString() {
                return "ListBean{" +
                        "bargainPrice='" + bargainPrice + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", detailUrl='" + detailUrl + '\'' +
                        ", images='" + images + '\'' +
                        ", itemtype='" + itemtype + '\'' +
                        ", pid='" + pid + '\'' +
                        ", price='" + price + '\'' +
                        ", pscid='" + pscid + '\'' +
                        ", salenum='" + salenum + '\'' +
                        ", sellerid='" + sellerid + '\'' +
                        ", subhead='" + subhead + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }

            public String getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(String bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getItemtype() {
                return itemtype;
            }

            public void setItemtype(String itemtype) {
                this.itemtype = itemtype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPscid() {
                return pscid;
            }

            public void setPscid(String pscid) {
                this.pscid = pscid;
            }

            public String getSalenum() {
                return salenum;
            }

            public void setSalenum(String salenum) {
                this.salenum = salenum;
            }

            public String getSellerid() {
                return sellerid;
            }

            public void setSellerid(String sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class MiaoshaBean {
        /**
         * list : [{"bargainPrice":99,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg","itemtype":1,"pid":45,"price":2999,"pscid":39,"salenum":4666,"sellerid":1,"subhead":"高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！","title":"一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机"},{},{},{},{},{},{},{},{},{},{},{}]
         * name : 京东秒杀
         * time : 7200000
         */

        private String name;
        private String time;
        private List<ListBeanX> list;

        @Override
        public String toString() {
            return "MiaoshaBean{" +
                    "name='" + name + '\'' +
                    ", time='" + time + '\'' +
                    ", list=" + list +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * bargainPrice : 99
             * createtime : 2017-10-14T21:38:26
             * detailUrl : https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg
             * itemtype : 1
             * pid : 45
             * price : 2999
             * pscid : 39
             * salenum : 4666
             * sellerid : 1
             * subhead : 高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！
             * title : 一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机
             */

            private String bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private String itemtype;
            private String pid;
            private String price;
            private String pscid;
            private String salenum;
            private String sellerid;
            private String subhead;
            private String title;

            @Override
            public String toString() {
                return "ListBeanX{" +
                        "bargainPrice='" + bargainPrice + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", detailUrl='" + detailUrl + '\'' +
                        ", images='" + images + '\'' +
                        ", itemtype='" + itemtype + '\'' +
                        ", pid='" + pid + '\'' +
                        ", price='" + price + '\'' +
                        ", pscid='" + pscid + '\'' +
                        ", salenum='" + salenum + '\'' +
                        ", sellerid='" + sellerid + '\'' +
                        ", subhead='" + subhead + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }

            public String getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(String bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getItemtype() {
                return itemtype;
            }

            public void setItemtype(String itemtype) {
                this.itemtype = itemtype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPscid() {
                return pscid;
            }

            public void setPscid(String pscid) {
                this.pscid = pscid;
            }

            public String getSalenum() {
                return salenum;
            }

            public void setSalenum(String salenum) {
                this.salenum = salenum;
            }

            public String getSellerid() {
                return sellerid;
            }

            public void setSellerid(String sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class DataBean {
        /**
         * aid : 1
         * createtime : 2017-12-26T21:49:44
         * icon : https://www.zhaoapi.cn/images/quarter/ad1.png
         * productId : null
         * title : 第十三界瑞丽模特大赛
         * type : 0
         * url : http://m.mv14449315.icoc.bz/index.jsp
         */

        private String aid;
        private String createtime;
        private String icon;
        private Object productId;
        private String title;
        private String type;
        private String url;

        @Override
        public String toString() {
            return "DataBean{" +
                    "aid='" + aid + '\'' +
                    ", createtime='" + createtime + '\'' +
                    ", icon='" + icon + '\'' +
                    ", productId=" + productId +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
