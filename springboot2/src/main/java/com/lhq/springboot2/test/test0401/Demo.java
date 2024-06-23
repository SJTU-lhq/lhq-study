package com.lhq.springboot2.test.test0401;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/4/1 19:45
 */

import java.util.*;

/**
 * connections = {
 *     "A": {"B": 20, "C": 30},
 *     "B": {"D": 15},
 *     "C": {"D": 25, "E": 40},
 *     "D": {"E": 10},
 *     "E": {}
 * }
 *
 * start_city = "A"
 * end_city = "E"
 * budget = 50
 *
 * print(find_routes(connections, start_city, end_city, budget))  # 应输出：[["A", "B", "D", "E"]]
 */
public class Demo {
    //假设你是一个旅行规划师，正在为一位旅行者设计一条从城市A到城市E的行程。已知存在一张由多个城市组成的地图，每两个城市之间可能存在多条道路相连，并且每条道路都有一个通行费用。
    //具体要求如下：
    //1. 编写一个名为 find_routes 的函数，接受以下参数：
    //    ○ connections：一个字典，键为城市名称（字符串），值为另一个字典，表示与该城市直接相连的所有城市的通行费用，如 {"A": {"B": 20, "C": 30}, ...}
    //    ○ start_city：一个字符串，表示旅行起点城市
    //    ○ end_city：一个字符串，表示旅行终点城市
    //    ○ budget：一个整数，表示旅行者的总预算
    //2. 函数应返回一个二维列表，每个子列表代表一条从起点到终点、总费用不超过预算的可行路线，如 [["A", "B", "D", "E"], ["A", "C", "E"]]

    public static List<List<String>> result = new ArrayList<>();
    static List<String> tmp = new ArrayList<>();
    public static List<List<String>> find_routes(Map<String, Map<String, Integer>> connections, String start_city, String end_city, int budget) {
        handle(connections, start_city, end_city, budget);
        return result;
    }

    public static void handle(Map<String, Map<String, Integer>> connections, String start_city, String end_city, int budget){
        Map<String, Integer> targetMap = connections.get(start_city);
        Set<String> targetSet = targetMap.keySet();
        tmp.add(start_city);
        for (String target : targetSet) {
            int remainBudget = budget - targetMap.get(target);
            if(target.equals(end_city)){
                if(remainBudget>=0){
                    tmp.add(target);
                    result.add(tmp);
                    tmp = new ArrayList<>();
                    return;
                }
            }
            handle(connections, target, end_city, remainBudget);
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> connections = new HashMap<>();
        Map<String, Integer> A = new HashMap<>();
        A.put("B", 20);
        A.put("C", 30);
        connections.put("A",  A);
        Map<String, Integer> B = new HashMap<>();
        B.put("D", 15);
        connections.put("B",  B);
        Map<String, Integer> C = new HashMap<>();
        C.put("D", 25);
        C.put("E", 40);
        connections.put("C",  C);
        Map<String, Integer> D = new HashMap<>();
        D.put("E", 10);
        connections.put("D",  D);
        Map<String, Integer> E = new HashMap<>();
        connections.put("E",  E);
        System.out.println(find_routes(connections, "A", "E", 50));
    }
}
