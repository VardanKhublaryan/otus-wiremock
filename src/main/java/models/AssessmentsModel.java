package models;

import lombok.Data;
import services.RestService;

@Data
public class AssessmentsModel extends RestService {
   private String name;
   private int score;
}
