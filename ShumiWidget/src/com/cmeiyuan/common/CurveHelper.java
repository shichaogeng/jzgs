package com.cmeiyuan.common;

import android.graphics.PointF;

/**
 * @author 334388454@qq.com
 */
public class CurveHelper {

	// 求A点到B点的三次贝塞尔曲线的两个控制点
	public static void curve3(PointF a, PointF b, PointF l, PointF n, PointF[] controls) {
		// 点a前一个点和点a的中点
		PointF cLA = PointHelper.center(l, a);
		// 点a和点b的中点
		PointF cAB = PointHelper.center(a, b);
		// 点b和点b后一个点的中点
		PointF cBN = PointHelper.center(b, n);

		// 点a前一个点到点a的距离
		float lenLA = PointHelper.distance(l, a);
		// 点a到点b的距离
		float lenAB = PointHelper.distance(a, b);
		// 点b到点b后一个点的距离
		float lenBN = PointHelper.distance(b, n);

		// cLA和cAB连线的比例点
		PointF cLAB = PointHelper.percent(cLA, cAB, lenLA / (lenLA + lenAB));
		PointF cABN = PointHelper.percent(cAB, cBN, lenAB / (lenAB + lenBN));

		// 顶点a和顶点b的控制点1
		controls[0] = PointHelper.translate(cAB, a.x - cLAB.x, a.y - cLAB.y);
		// 顶点a和顶点b的控制点2
		controls[1] = PointHelper.translate(cAB, b.x - cABN.x, b.y - cABN.y);
		
	}

}
