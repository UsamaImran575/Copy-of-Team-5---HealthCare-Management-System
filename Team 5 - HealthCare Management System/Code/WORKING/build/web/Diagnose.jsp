<%-- 
    Document   : Diagnose
    Created on : Apr 13, 2020, 2:09:05 AM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="com.health.data.Prescribe"%>
<%@page import="com.health.data.Medicine"%>
<%@page import="com.health.data.Symptom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.health.data.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Docmed</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div class="header-top_area">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-6 col-md-6 ">
                            
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <div class="short_contact_list">
                                <ul>
                                   
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="sticky-header" class="main-header-area">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-3 col-lg-2">
                            <div class="logo">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="index.jsp">Home</a></li>
                                        <li><a href="Department.jsp">Diagnose Disease</a></li>
                                        <li><a  href="history.jsp">History</a>
                                        </li>
                                        
                                        <li><a href="Doctors.jsp">Chat Area</a></li>
                                        <li><a href="about.jsp">about</a></li>
					
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                           
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->


    <!-- bradcam_area_start  -->
    <div class="bradcam_area breadcam_bg bradcam_overlay">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3>Diagnosis</h3>
                        <p><a href="index.jsp">Home /</a> Services</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- bradcam_area_end  -->

    
    <!-- offers_area_start -->
    <div class="our_department_area">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title text-center mb-55">
                        <h3>Diagnosis</h3>
                        <p>Keep your vitality. <br>
                            A life without health is like a river without water.</p>
                    </div>
                </div>
            </div>
            
    </div>
    <!-- offers_area_end -->

    <!-- testmonial_area_start -->
    
    <!-- business_expert_area_start  -->
    
    <!-- business_expert_area_end  -->

<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Diagnosed</h3>
     <%
       Patient p=(Patient)session.getAttribute("currentUser");
       String str= (String)session.getAttribute("a");
       int age= Integer.parseInt(str);
       ArrayList<Symptom> ab;
       ab=p.getMy_Symptoms();
      p.askDoctor(ab);
       p.askPharmacist();
      ArrayList<Medicine> f= p.getCurrent_Medicicines();
       List<Prescribe> abc= new ArrayList(); 
       ArrayList<String> cons=p.getCurrent_Disease().getConstraints();
       for(int i=0;i<f.size();i++)
       {
           abc.add(new Prescribe(p.getCurrent_Disease().get_Name(),f.get(i).getId(),age));
       }
     %>
     <p> &emsp;&emsp;&emsp;&emsp;&emsp;<%=p.getCurrent_Disease().get_Name() %><p>
         
     

</br>
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Medicines And Prescription</h3>
<%
    for (int i=0;i<f.size();i++)
    {
    %>
    <h5>&emsp;&emsp;&emsp;&emsp;Name</h5> <P> &emsp;&emsp;&emsp;&emsp;&emsp;<%=f.get(i).getName() %></P>
    <h5>&emsp;&emsp;&emsp;&emsp;Price</h5> <P>&emsp;&emsp;&emsp;&emsp;&emsp;<%=f.get(i).getPrice() %> &nbsp;Rs </P>
    <h5>&emsp;&emsp;&emsp;&emsp;Prescription</h5> 
     <h4>&emsp;&emsp;&emsp;&emsp;&emsp;Dosage</h4> 
     <p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%=abc.get(i).getDosage()%> &nbsp;mg </p>
     <h4>&emsp;&emsp;&emsp;&emsp;&emsp;Duration</h4> 
       <p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%=abc.get(i).getDuration()   %> &nbsp;days</p>
     <h4>&emsp;&emsp;&emsp;&emsp;&emsp;Times In Day</h4> 
       <p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%=abc.get(i).getTime()  %> </p>
    <p> </p>
    <%
        }
    %>

</br>
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Constrain on Food</h3>


<%
    for (int i=0;i<cons.size();i++)
    {
    %>
    <P>&emsp;&emsp;&emsp;&emsp;&emsp;<%=cons.get(i) %></P>
    
    <%
        }
    p.updateHistory(p.getCurrent_Disease().get_Name(),p.getUid());
    %>
</br>

</div>

   
    <!-- link that opens popup -->

    <!-- form itself end-->
    <form id="test-form" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <h3>Make an Appointment</h3>
                <form action="#">
                    <div class="row">
                        <div class="col-xl-6">
                            <input id="datepicker" placeholder="Pick date">
                        </div>
                        <div class="col-xl-6">
                            <input id="datepicker2" placeholder="Suitable time">
                        </div>
                        <div class="col-xl-6">
                            <select class="form-select wide" id="default-select" class="">
                                <option data-display="Select Department">Department</option>
                                <option value="1">2</option>
                                <option value="2">3</option>
                                <option value="3">4</option>
                            </select>
                        </div>
                        <div class="col-xl-6">
                            <select class="form-select wide" id="default-select" class="">
                                <option data-display="Doctors">Doctors</option>
                                <option value="1">2</option>
                                <option value="2">3</option>
                                <option value="3">4</option>
                            </select>
                        </div>
                        <div class="col-xl-6">
                            <input type="text"  placeholder="Name">
                        </div>
                        <div class="col-xl-6">
                            <input type="text"  placeholder="Phone no.">
                        </div>
                        <div class="col-xl-12">
                            <input type="email"  placeholder="Email">
                        </div>
                        <div class="col-xl-12">
                            <button type="submit" class="boxed-btn3">Confirm</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </form>
    <!-- form itself end -->

    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>
    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>

    <script src="js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }

        });
    $(document).ready(function() {
    $('.js-example-basic-multiple').select2();
});
    </script>
</body>

</html>