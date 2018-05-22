<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html lang="en"> 
<head>
  <title>2018 Fifa Tournament Bracket</title>
  <meta name="description" content="2015 NCAA Tournament Men's Basketball Bracket" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="UTF-8" />
  <meta http-equiv="Content-Language" content="en" />

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
  <script src="js/miso.ds.deps.min.0.4.1.js"></script>
  
  <link href="css/bracket.css" rel="stylesheet" />

</head>

<body>


  <div id="col3">
    <div class="vliner">
      <div class="slot c3" id="c3s1" data-col="3" data-game="1"></div>
      <div class="slot c3" id="c3s2" data-col="3" data-game="1"></div>
    </div>
    <div class="vliner">
      <div class="slot c3" id="c3s3" data-col="3" data-game="2"></div>
      <div class="slot c3" id="c3s4" data-col="3" data-game="2"></div>
    </div>
    
    <div class="vliner">
      <div class="slot c3b" id="c3s5" data-col="3" data-game="3"></div>
      <div class="slot c3b" id="c3s6" data-col="3" data-game="3"></div>
    </div>
    <div class="vliner">
      <div class="slot c3b" id="c3s7" data-col="3" data-game="4"></div>
      <div class="slot c3b" id="c3s8" data-col="3" data-game="4"></div>
    </div>

  </div>

  <div id="col4">
    <div class="vliner">
      <div class="slot c4" id="c4s1" data-col="4" data-game="1"></div>
      <div class="slot c4" id="c4s2" data-col="4" data-game="1"></div>
    </div>
    <div class="spacer15"></div>
    <div class="vliner">
      <div class="slot c4" id="c4s3" data-col="4" data-game="2"></div>
      <div class="slot c4" id="c4s4" data-col="4" data-game="2"></div>
    </div>
  </div>

  <div id="col5">
    <div class="vliner">
      <div class="slot c5" id="c5s1" data-col="5" data-game="1"></div>
      <div class="spacer180"></div>
      <div class="slot c5" id="c5s2" data-col="5" data-game="1"></div>
    </div>
  </div>

  <div id="col6">
      <div class="slot c6" id="c6s1" data-col="6" data-game="1"></div>
      <div class="slot c6 winner" id="c6s0" data-col="6" data-game="0"></div>
      <div class="slot c6" id="c6s2" data-col="6" data-game="2"></div>
  </div>

  <div id="col7">
   <div class="vlinel">
     <div class="slot c7" id="c7s1" data-col="7" data-game="2"></div>
     <div class="spacer180"></div>
      <div class="slot c7" id="c7s2" data-col="7" data-game="2"></div>
    </div>
  </div>

  <div id="col8">
    <div class="vlinel">
      <div class="slot c8" id="c8s1" data-col="8" data-game="1"></div>
      <div class="slot c8" id="c8s2" data-col="8" data-game="1"></div>
    </div>
    <div class="spacer15"></div>
    <div class="vlinel">
      <div class="slot c8" id="c8s3" data-col="8" data-game="2"></div>
      <div class="slot c8" id="c8s4" data-col="8" data-game="2"></div>
    </div>
  </div>

  <div id="col9">
    <div class="vlinel">
      <div class="slot c9" id="c9s1" data-col="9" data-game="1"></div>
      <div class="slot c9" id="c9s2" data-col="9" data-game="1"></div>
    </div>
    <div class="vlinel">
      <div class="slot c9" id="c9s3" data-col="9" data-game="2"></div>
      <div class="slot c9" id="c9s4" data-col="9" data-game="2"></div>
    </div>

    <div class="vlinel">
      <div class="slot c9b" id="c9s5" data-col="9" data-game="3"></div>
      <div class="slot c9b" id="c9s6" data-col="9" data-game="3"></div>
    </div>
    <div class="vlinel">
      <div class="slot c9b" id="c9s7" data-col="9" data-game="4"></div>
      <div class="slot c9b" id="c9s8" data-col="9" data-game="4"></div>
    </div>
  </div>

  <div id="FifaArr" ></div>
    <form action="/fifaData" method="POST">
        <input id="myData" type="hidden"  name="myData">
        <input type="submit" value="Submit">
    </form>
  <script src="js/bracket.js"></script>

  

</body>


</html>

