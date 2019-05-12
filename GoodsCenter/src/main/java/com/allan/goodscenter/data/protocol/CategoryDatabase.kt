package com.allan.goodscenter.data.protocol

fun getCategoryFromDatabase(categoryId: Int): MutableList<Category> {
    val categories = ArrayList<Category>()
    when (categoryId) {
        0 -> {
            categories.add(Category(1, "电脑办公", "", 0))
            categories.add(Category(2, "手机数码", "", 0))
            categories.add(Category(3, "男装", "", 0))
            categories.add(Category(4, "女装", "", 0))
            categories.add(Category(5, "家用电器", "", 0))
            categories.add(Category(6, "食品生鲜", "", 0))
            categories.add(Category(7, "酒水饮料", "", 0))
            categories.add(Category(8, "玩具乐器", "", 0))
            categories.add(Category(9, "汽车用品", "", 0))
            categories.add(Category(10, "家具家装", "", 0))
            categories.add(Category(11, "礼品鲜花", "", 0))
            categories.add(Category(12, "生活旅行", "", 0))
            categories.add(Category(13, "二手商品", "", 0))
        }
        1 -> {
            categories.add(
                Category(
                    14,
                    "Apple",
                    "https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    15,
                    "ThinkPad",
                    "https://img14.360buyimg.com/n7/jfs/t3556/223/2158676156/110226/59267230/584b5678Nbc9f1e70.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    16,
                    "惠普",
                    "https://img10.360buyimg.com/n7/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    17,
                    "戴尔",
                    "https://img14.360buyimg.com/n7/jfs/t5971/255/1793524379/148460/f42e1432/59362fc2Nf55191b9.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    18,
                    "华硕",
                    "https://img12.360buyimg.com/n7/jfs/t5878/352/2479795637/201591/d23a1872/5931182fN31cfa389.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    19,
                    "神舟",
                    "https://img13.360buyimg.com/n7/jfs/t3052/126/5163722736/217313/f05d9003/5864c7dfNcfbc5e94.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    20,
                    "外星人",
                    "https://img11.360buyimg.com/n7/jfs/t4687/130/1245474410/58260/f12a15bd/58db17dbNf5371a02.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    21,
                    "微星",
                    "https://img12.360buyimg.com/n7/jfs/t6709/106/1129266372/226149/ab5f4641/594b8094Nb07793ab.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    22,
                    "宏基",
                    "https://img11.360buyimg.com/n7/jfs/t5737/312/4822081047/162369/70bbd1b2/5954b785N1787db72.jpg",
                    1
                )
            )
            categories.add(
                Category(
                    23,
                    "雷神",
                    "https://img11.360buyimg.com/n7/jfs/t5671/2/2653805329/277901/cf0384f7/5932281fNeb08da02.jpg",
                    1
                )
            )

        }
        2 -> {
            categories.add(
                Category(
                    24,
                    "Apple",
                    "https://img14.360buyimg.com/n7/jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    25,
                    "华为",
                    "https://img10.360buyimg.com/n7/jfs/t5890/341/1320350439/127171/2f9c4ddd/592535e0N2e102c09.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    26,
                    "小米",
                    "https://img14.360buyimg.com/n7/jfs/t5215/252/15502760/100416/cb06f1da/58f709adN45511018.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    27,
                    "魅族",
                    "https://img10.360buyimg.com/n7/jfs/t4366/71/2045605853/291379/56c87b03/58ca4dc5N1c303706.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    28,
                    "三星",
                    "https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    29,
                    "OPPO",
                    "https://img10.360buyimg.com/n7/jfs/t5785/24/2243796048/134801/923e11/592ea14fNec6d33c4.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    30,
                    "vivo",
                    "https://img11.360buyimg.com/n7/jfs/t5998/69/1052614141/116889/2f5ba58a/592f8ed9N49d8f07b.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    31,
                    "HTC",
                    "https://img13.360buyimg.com/n7/jfs/t5659/277/3541677944/291221/28bb44f8/593e10c9Nc3783014.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    32,
                    "摩托罗拉",
                    "https://img12.360buyimg.com/n7/jfs/t3109/185/1064081632/117451/2dba5e92/57c558e2N38a9e617.jpg",
                    2
                )
            )
            categories.add(
                Category(
                    33,
                    "索尼",
                    "https://img10.360buyimg.com/n7/jfs/t5191/190/2535818793/70090/78c559f5/591ba9f0Nd3a41fcb.jpg",
                    2
                ))
        }
    }

    return categories
}