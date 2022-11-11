package rs.ftn.uns.btb.service;

import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.SurveyAnswers;

import java.util.ArrayList;
import java.util.Collection;

public interface SurveyAnswerService {
    SurveyAnswers create(ArrayList<SurveyAnswers> surveyAnswers) throws Exception;
}
