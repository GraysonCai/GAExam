package com.cgs.gaexam.model.dto;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class AnswerSheet {

    private List<AnswerSheetItem> answerSheetItems;

    @Override
    public String toString() {
        return "AnswerSheet{" +
                "answerSheetItems=" + answerSheetItems +
                '}';
    }

    public List<AnswerSheetItem> getAnswerSheetItems() {
        return answerSheetItems;
    }

    public void setAnswerSheetItems(List<AnswerSheetItem> answerSheetItems) {
        this.answerSheetItems = answerSheetItems;
    }

    public static void main(String[] args) {
        AnswerSheetItem item1 = new AnswerSheetItem(1L, 33L, "A");
        AnswerSheetItem item2 = new AnswerSheetItem(1L, 34L, "B");
        AnswerSheetItem item3 = new AnswerSheetItem(1L, 35L, "C");
        AnswerSheetItem item4 = new AnswerSheetItem(2L, 36L, "A,B");
        AnswerSheetItem item5 = new AnswerSheetItem(2L, 37L, "B,C");
        AnswerSheetItem item6 = new AnswerSheetItem(2L, 38L, "C,D");
        List<AnswerSheetItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setAnswerSheetItems(items);
        String str = JSON.toJSONString(answerSheet);
        System.out.println(str);
    }
}
