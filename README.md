AJOFC stands for "Another Java API for Open Flash Chart 2" :)

关于[OpenFlashChart](http://teethgrinder.co.uk/open-flash-chart-2/tutorial.php)的使用，请参考[官方教程](http://teethgrinder.co.uk/open-flash-chart-2/tutorial.php)。

java程序怎么写？

答：非常简单，比如画折线图：

    // 声明一个数组，也可以是个List
    Integer[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    // 实例化一个JLineChart对象
    JLineChart lineChart = new JLineChart();
    // 添加一条折线
    lineChart.addLine(values);
    // 打印出来
    System.out.println(lineChart.toString());
    // JLineChart类是一个给用户使用的门面类，除了添加折线，里面还有各种各样的功能，
    // 比如设置折线颜色，动画效果，XY轴的文字和样式，坐标点样式等等

画饼状图，同理：

    // 声明一个数组，也可以是个List
    Integer[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    // 实例化一个JPieChart对象
    JPieChart pieChart = new JPieChart();
    // 添加一个饼图
    pieChart.setValues(values);
    // 打印出来
    System.out.println(pieChart.toString());
    // 同样，JPieChart类是一个给用户使用的门面类，里面还有其他很多功能，
    // 详细说明可以查看方法上的注释

目前完成的是折线图，饼状图和柱状图，其他图形的接口还没有完成，敬请期待~ 
