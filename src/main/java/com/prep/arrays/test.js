var sorter = {
  "MON": 1,
  "TUE": 2,
  "WED": 3,
  "THU": 4,
  "FRI": 5,
  "SAT": 6,
  "SUN": 7
}

 var daysofweek=['MON','TUE'] ;
var oneDArray = function(weekArray){

  var week = []; 
  for(var  i=0; i< weekArray.length;i++){
        var conDays = weekArray[i];
        if((sorter[conDays[1]] - sorter[conDays[0]]) === 0 ){
            week[i] = conDays[];
        }
        else if((sorter[conDays[1]] - sorter[conDays[0]]) === 1 ){
            week[i] = conDays;
        }else{
            week[i] = conDays.join("-");
        } 
  }
  return week.join();
};

var convertToWeekRanges = function (week) {
       var weekRanges = [] 
       weekRanges[0] = [week[0], week[0]];
       var  lastIndex = 0;

    for (var i = 1; i < week.length; i++) {
        
        if ((sorter[week[i]] - sorter[weekRanges[lastIndex][1]]) === 1) {
            weekRanges[lastIndex][1] = week[i];
        } else {
            weekRanges[++lastIndex] = [week[i], week[i]];
        }
    }
    return weekRanges;
};
oneDArray(convertToWeekRanges(daysofweek));











