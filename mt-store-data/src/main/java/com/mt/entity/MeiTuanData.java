package com.mt.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */

@Data
public class MeiTuanData {

    /**
     * code : 0
     * data : {"template":"pcfood","searchResult":[{"template":"pcfood","landmarkDistance":null,"dangleAbstracts":null,"ct_poi":null,"distance":"","adsShowUrl":"","city":"济南","latitude":36.664675,"cityId":96,"title":"美客拍拍摄影主题餐厅(可堂食)（世茂店）","historyCouponCount":98985,"trace":null,"imageUrl":"https://img.meituan.net/w.h/msmerchant/56591bc4fc3c4360c329d263ddbc4aac152618.jpg","showType":"food","id":40709053,"tag":[],"longitude":117.028597,"adsClickUrl":"","cate":[1,20632,20426,20557],"address":"历下区舜井街6号世茂广场西座五楼西南角（我家牛排后面）","avgprice":50,"comments":22621,"titleTags":[],"areaname":"世茂国际广场","abstracts":[{"backgroundColor":null,"borderColor":null,"icon":"https://p0.meituan.net/travelcube/66e6ab0f49b056f98d2b2a3f21567c731145.png","text":"","message":"4人餐139元，双人餐98.9元，双人餐79元，双人餐105元，6人餐238元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/348758503e87285267788a5d5b64d777779.png","text":"","message":"85代100元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/5166f1958bb4a8c9a3cd76fda7939ed0728.png","text":"","message":"满39减10;满75减20","fontColor":null}],"posdescr":null,"lowestprice":78,"hasAds":false,"phone":"0531-86878999/13964019075","avgscore":4.7,"iUrl":null,"deals":[{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":139,"iUrl":"","stid":null,"id":28563456,"tag":{"promotion":[]},"title":"4人套餐，提供免费WiFi","value":262,"sales":35322},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":98.9,"iUrl":"","stid":null,"id":29644518,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":167,"sales":19533},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42451543,"tag":{"promotion":[]},"title":"两人套餐，提供免费WiFi","value":171,"sales":13610},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":85,"iUrl":"","stid":null,"id":28138133,"tag":{"promotion":[]},"title":"100元代金券1张，可叠加","value":100,"sales":15506},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":105,"iUrl":"","stid":null,"id":67945423,"tag":{"promotion":[]},"title":"精品双人餐，提供免费WiFi","value":184,"sales":7205},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":238,"iUrl":"","stid":null,"id":29644515,"tag":{"promotion":[]},"title":"6人套餐，提供免费WiFi","value":417,"sales":4632},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42436666,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":152,"sales":4731},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":298,"iUrl":"","stid":null,"id":29054053,"tag":{"promotion":[]},"title":"团建聚餐聚会8人套餐","value":538,"sales":4211},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":398,"iUrl":"","stid":null,"id":30352030,"tag":{"promotion":[]},"title":"聚餐10人套餐，提供免费WiFi","value":677,"sales":1872},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":78,"iUrl":"","stid":null,"id":644899605,"tag":{"promotion":[]},"title":"双人精品套餐，提供免费WiFi","value":148,"sales":7}],"backCateName":"鲁菜","recentScreen":null,"full":false}],"extraInfoCinema":null,"serverInfo":{"traceId":"7b2bf0ab-1bee-4882-a924-3658880a3d3f","searchId":"1162999851282462679","globalId":"111268095243909880","queryId":"9048548554365052970"},"recommendResult":[],"stid":null,"totalCount":2000,"cardExtension":{"redirecturl":"imeituan://www.meituan.com/food/homepage","imageInfos":[{"img":"https://p0.meituan.net/travelcube/bf03d48d088a6811b79187a9e0d2c905426505.png","iurl":"imeituan://www.meituan.com/food/homepage"}],"ct_poi":"178193079681851423068815276075113263088_dcard_e111268095243909880","catetag":"进入频道","templateid":"6","title":"美团美食","trace":{"offset":"0","cateid":"20","requestid":"7b2bf0ab-1bee-4882-a924-3658880a3d3f","globalid":"111268095243909880","id":"24","type":"CARD","queryid":"9048548554365052970"},"cateid":"20","cardInfos":[],"cardinfo2":"","iconUrl":"https://p1.meituan.net/travelcube/498fc7fc6495c6c4800b010fa47cd1cf2728.png","id":24,"cardinfo1":""}}
     */
    private String code;
    private DataEntity data;

    public class DataEntity {
        /**
         * template : pcfood
         * searchResult : [{"template":"pcfood","landmarkDistance":null,"dangleAbstracts":null,"ct_poi":null,"distance":"","adsShowUrl":"","city":"济南","latitude":36.664675,"cityId":96,"title":"美客拍拍摄影主题餐厅(可堂食)（世茂店）","historyCouponCount":98985,"trace":null,"imageUrl":"https://img.meituan.net/w.h/msmerchant/56591bc4fc3c4360c329d263ddbc4aac152618.jpg","showType":"food","id":40709053,"tag":[],"longitude":117.028597,"adsClickUrl":"","cate":[1,20632,20426,20557],"address":"历下区舜井街6号世茂广场西座五楼西南角（我家牛排后面）","avgprice":50,"comments":22621,"titleTags":[],"areaname":"世茂国际广场","abstracts":[{"backgroundColor":null,"borderColor":null,"icon":"https://p0.meituan.net/travelcube/66e6ab0f49b056f98d2b2a3f21567c731145.png","text":"","message":"4人餐139元，双人餐98.9元，双人餐79元，双人餐105元，6人餐238元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/348758503e87285267788a5d5b64d777779.png","text":"","message":"85代100元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/5166f1958bb4a8c9a3cd76fda7939ed0728.png","text":"","message":"满39减10;满75减20","fontColor":null}],"posdescr":null,"lowestprice":78,"hasAds":false,"phone":"0531-86878999/13964019075","avgscore":4.7,"iUrl":null,"deals":[{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":139,"iUrl":"","stid":null,"id":28563456,"tag":{"promotion":[]},"title":"4人套餐，提供免费WiFi","value":262,"sales":35322},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":98.9,"iUrl":"","stid":null,"id":29644518,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":167,"sales":19533},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42451543,"tag":{"promotion":[]},"title":"两人套餐，提供免费WiFi","value":171,"sales":13610},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":85,"iUrl":"","stid":null,"id":28138133,"tag":{"promotion":[]},"title":"100元代金券1张，可叠加","value":100,"sales":15506},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":105,"iUrl":"","stid":null,"id":67945423,"tag":{"promotion":[]},"title":"精品双人餐，提供免费WiFi","value":184,"sales":7205},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":238,"iUrl":"","stid":null,"id":29644515,"tag":{"promotion":[]},"title":"6人套餐，提供免费WiFi","value":417,"sales":4632},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42436666,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":152,"sales":4731},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":298,"iUrl":"","stid":null,"id":29054053,"tag":{"promotion":[]},"title":"团建聚餐聚会8人套餐","value":538,"sales":4211},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":398,"iUrl":"","stid":null,"id":30352030,"tag":{"promotion":[]},"title":"聚餐10人套餐，提供免费WiFi","value":677,"sales":1872},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":78,"iUrl":"","stid":null,"id":644899605,"tag":{"promotion":[]},"title":"双人精品套餐，提供免费WiFi","value":148,"sales":7}],"backCateName":"鲁菜","recentScreen":null,"full":false}]
         * extraInfoCinema : null
         * serverInfo : {"traceId":"7b2bf0ab-1bee-4882-a924-3658880a3d3f","searchId":"1162999851282462679","globalId":"111268095243909880","queryId":"9048548554365052970"}
         * recommendResult : []
         * stid : null
         * totalCount : 2000
         * cardExtension : {"redirecturl":"imeituan://www.meituan.com/food/homepage","imageInfos":[{"img":"https://p0.meituan.net/travelcube/bf03d48d088a6811b79187a9e0d2c905426505.png","iurl":"imeituan://www.meituan.com/food/homepage"}],"ct_poi":"178193079681851423068815276075113263088_dcard_e111268095243909880","catetag":"进入频道","templateid":"6","title":"美团美食","trace":{"offset":"0","cateid":"20","requestid":"7b2bf0ab-1bee-4882-a924-3658880a3d3f","globalid":"111268095243909880","id":"24","type":"CARD","queryid":"9048548554365052970"},"cateid":"20","cardInfos":[],"cardinfo2":"","iconUrl":"https://p1.meituan.net/travelcube/498fc7fc6495c6c4800b010fa47cd1cf2728.png","id":24,"cardinfo1":""}
         */
        private String template;
        private List<SearchResultEntity> searchResult;
        private String extraInfoCinema;
        private ServerInfoEntity serverInfo;
        private List<?> recommendResult;
        private String stid;
        private int totalCount;
        private CardExtensionEntity cardExtension;


        @Data
        public class SearchResultEntity {
            /**
             * template : pcfood
             * landmarkDistance : null
             * dangleAbstracts : null
             * ct_poi : null
             * distance :
             * adsShowUrl :
             * city : 济南
             * latitude : 36.664675
             * cityId : 96
             * title : 美客拍拍摄影主题餐厅(可堂食)（世茂店）
             * historyCouponCount : 98985
             * trace : null
             * imageUrl : https://img.meituan.net/w.h/msmerchant/56591bc4fc3c4360c329d263ddbc4aac152618.jpg
             * showType : food
             * id : 40709053
             * tag : []
             * longitude : 117.028597
             * adsClickUrl :
             * cate : [1,20632,20426,20557]
             * address : 历下区舜井街6号世茂广场西座五楼西南角（我家牛排后面）
             * avgprice : 50.0
             * comments : 22621
             * titleTags : []
             * areaname : 世茂国际广场
             * abstracts : [{"backgroundColor":null,"borderColor":null,"icon":"https://p0.meituan.net/travelcube/66e6ab0f49b056f98d2b2a3f21567c731145.png","text":"","message":"4人餐139元，双人餐98.9元，双人餐79元，双人餐105元，6人餐238元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/348758503e87285267788a5d5b64d777779.png","text":"","message":"85代100元","fontColor":null},{"backgroundColor":null,"borderColor":null,"icon":"http://p0.meituan.net/groupop/5166f1958bb4a8c9a3cd76fda7939ed0728.png","text":"","message":"满39减10;满75减20","fontColor":null}]
             * posdescr : null
             * lowestprice : 78.0
             * hasAds : false
             * phone : 0531-86878999/13964019075
             * avgscore : 4.7
             * iUrl : null
             * deals : [{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":139,"iUrl":"","stid":null,"id":28563456,"tag":{"promotion":[]},"title":"4人套餐，提供免费WiFi","value":262,"sales":35322},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":98.9,"iUrl":"","stid":null,"id":29644518,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":167,"sales":19533},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42451543,"tag":{"promotion":[]},"title":"两人套餐，提供免费WiFi","value":171,"sales":13610},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":85,"iUrl":"","stid":null,"id":28138133,"tag":{"promotion":[]},"title":"100元代金券1张，可叠加","value":100,"sales":15506},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":105,"iUrl":"","stid":null,"id":67945423,"tag":{"promotion":[]},"title":"精品双人餐，提供免费WiFi","value":184,"sales":7205},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":238,"iUrl":"","stid":null,"id":29644515,"tag":{"promotion":[]},"title":"6人套餐，提供免费WiFi","value":417,"sales":4632},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":79,"iUrl":"","stid":null,"id":42436666,"tag":{"promotion":[]},"title":"2人套餐，提供免费WiFi","value":152,"sales":4731},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":298,"iUrl":"","stid":null,"id":29054053,"tag":{"promotion":[]},"title":"团建聚餐聚会8人套餐","value":538,"sales":4211},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":398,"iUrl":"","stid":null,"id":30352030,"tag":{"promotion":[]},"title":"聚餐10人套餐，提供免费WiFi","value":677,"sales":1872},{"subtitleB":null,"subtitleC":null,"trace":null,"subtitleA":null,"price":78,"iUrl":"","stid":null,"id":644899605,"tag":{"promotion":[]},"title":"双人精品套餐，提供免费WiFi","value":148,"sales":7}]
             * backCateName : 鲁菜
             * recentScreen : null
             * full : false
             */
            private String template;
            private String landmarkDistance;
            private String dangleAbstracts;
            private String ct_poi;
            private String distance;
            private String adsShowUrl;
            private String city;
            private double latitude;
            private int cityId;
            private String title;
            private int historyCouponCount;
            private String trace;
            private String imageUrl;
            private String showType;
            private int id;
            private List<?> tag;
            private double longitude;
            private String adsClickUrl;
            private List<Integer> cate;
            private String address;
            private double avgprice;
            private int comments;
            private List<?> titleTags;
            private String areaname;
            private List<AbstractsEntity> abstracts;
            private String posdescr;
            private double lowestprice;
            private boolean hasAds;
            private String phone;
            private double avgscore;
            private String iUrl;
            private List<DealsEntity> deals;
            private String backCateName;
            private String recentScreen;
            private boolean full;
            @Data
            public class AbstractsEntity {
                /**
                 * backgroundColor : null
                 * borderColor : null
                 * icon : https://p0.meituan.net/travelcube/66e6ab0f49b056f98d2b2a3f21567c731145.png
                 * text :
                 * message : 4人餐139元，双人餐98.9元，双人餐79元，双人餐105元，6人餐238元
                 * fontColor : null
                 */
                private String backgroundColor;
                private String borderColor;
                private String icon;
                private String text;
                private String message;
                private String fontColor;

            }
            @Data
            public class DealsEntity {
                /**
                 * subtitleB : null
                 * subtitleC : null
                 * trace : null
                 * subtitleA : null
                 * price : 139.0
                 * iUrl :
                 * stid : null
                 * id : 28563456
                 * tag : {"promotion":[]}
                 * title : 4人套餐，提供免费WiFi
                 * value : 262.0
                 * sales : 35322.0
                 */
                private String subtitleB;
                private String subtitleC;
                private String trace;
                private String subtitleA;
                private double price;
                private String iUrl;
                private String stid;
                private int id;
                private TagEntity tag;
                private String title;
                private double value;
                private double sales;

                public void setSubtitleB(String subtitleB) {
                    this.subtitleB = subtitleB;
                }

                public void setSubtitleC(String subtitleC) {
                    this.subtitleC = subtitleC;
                }

                public void setTrace(String trace) {
                    this.trace = trace;
                }

                public void setSubtitleA(String subtitleA) {
                    this.subtitleA = subtitleA;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public void setIUrl(String iUrl) {
                    this.iUrl = iUrl;
                }

                public void setStid(String stid) {
                    this.stid = stid;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setTag(TagEntity tag) {
                    this.tag = tag;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public void setSales(double sales) {
                    this.sales = sales;
                }

                public String getSubtitleB() {
                    return subtitleB;
                }

                public String getSubtitleC() {
                    return subtitleC;
                }

                public String getTrace() {
                    return trace;
                }

                public String getSubtitleA() {
                    return subtitleA;
                }

                public double getPrice() {
                    return price;
                }

                public String getIUrl() {
                    return iUrl;
                }

                public String getStid() {
                    return stid;
                }

                public int getId() {
                    return id;
                }

                public TagEntity getTag() {
                    return tag;
                }

                public String getTitle() {
                    return title;
                }

                public double getValue() {
                    return value;
                }

                public double getSales() {
                    return sales;
                }

                public class TagEntity {
                    /**
                     * promotion : []
                     */
                    private List<?> promotion;

                    public void setPromotion(List<?> promotion) {
                        this.promotion = promotion;
                    }

                    public List<?> getPromotion() {
                        return promotion;
                    }
                }
            }
        }
        @Data
        public class ServerInfoEntity {
            /**
             * traceId : 7b2bf0ab-1bee-4882-a924-3658880a3d3f
             * searchId : 1162999851282462679
             * globalId : 111268095243909880
             * queryId : 9048548554365052970
             */
            private String traceId;
            private String searchId;
            private String globalId;
            private String queryId;
        }
        @Data
        public class CardExtensionEntity {
            /**
             * redirecturl : imeituan://www.meituan.com/food/homepage
             * imageInfos : [{"img":"https://p0.meituan.net/travelcube/bf03d48d088a6811b79187a9e0d2c905426505.png","iurl":"imeituan://www.meituan.com/food/homepage"}]
             * ct_poi : 178193079681851423068815276075113263088_dcard_e111268095243909880
             * catetag : 进入频道
             * templateid : 6
             * title : 美团美食
             * trace : {"offset":"0","cateid":"20","requestid":"7b2bf0ab-1bee-4882-a924-3658880a3d3f","globalid":"111268095243909880","id":"24","type":"CARD","queryid":"9048548554365052970"}
             * cateid : 20
             * cardInfos : []
             * cardinfo2 :
             * iconUrl : https://p1.meituan.net/travelcube/498fc7fc6495c6c4800b010fa47cd1cf2728.png
             * id : 24
             * cardinfo1 :
             */
            private String redirecturl;
            private List<ImageInfosEntity> imageInfos;
            private String ct_poi;
            private String catetag;
            private String templateid;
            private String title;
            private TraceEntity trace;
            private String cateid;
            private List<?> cardInfos;
            private String cardinfo2;
            private String iconUrl;
            private int id;
            private String cardinfo1;

            @Data
            public class ImageInfosEntity {
                /**
                 * img : https://p0.meituan.net/travelcube/bf03d48d088a6811b79187a9e0d2c905426505.png
                 * iurl : imeituan://www.meituan.com/food/homepage
                 */
                private String img;
                private String iurl;

            }

            @Data
            public class TraceEntity {
                /**
                 * offset : 0
                 * cateid : 20
                 * requestid : 7b2bf0ab-1bee-4882-a924-3658880a3d3f
                 * globalid : 111268095243909880
                 * id : 24
                 * type : CARD
                 * queryid : 9048548554365052970
                 */
                private String offset;
                private String cateid;
                private String requestid;
                private String globalid;
                private String id;
                private String type;
                private String queryid;

            }
        }
    }
}
