<%@page import="java.util.ArrayList"%>
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
                                <ul></ul>
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
                                        <li><a  href="DoctorView.jsp">Doctor Details</a></li>
                                        <li><a class="active" href="addDisease.jsp">AddDisease</a></li>
                                        <li><a  href="removeDisease.jsp">RemoveDisease</a></li>
                                        <li><a href="displaydisease.jsp">View Diseases</a></li>
                                        <li><a href="Doctors_1.jsp"> Chat Area </a></li>

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
    <div class="bradcam_area breadcam_bg_2 bradcam_overlay">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3>Doctor</h3>
                        <p><a href="addDisease.jsp">AddDisease/</a>Doctor</p>
                        <form action="AddDisease">
                            <div class="container">


                                <hr>
                              
                                <label for="name"><b>Enter Name</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" placeholder="Enter name of Disease " name="dname" required><br>
                                 <h4> Enter Symptoms <h5> (At least 2)</h5></h4>
				<label for="name"><b>Enter Symptom 1</b></label>					
				<input type="text" placeholder="Enter Symptom 1 " name="Symptom1" required><br>
				<label for="name"><b>Enter Symptom 2</b></label>
				<input type="text" placeholder="Enter Symptom 2 " name="Symptom2" required><br>
				<label for="name"><b>Enter Symptom 3</b></label>
				<input type="text" placeholder="Enter Symptom 3 " name="Symptom3" ><br>
                                <label for="name"><b>Enter Symptom 4</b></label>
                                <input type="text" placeholder="Enter Symptom 4 " name="Symptom4"><br>
				<label for="name"><b>Enter Symptom 5</b></label>
				<input type="text" placeholder="Enter Symptom 5 " name="Symptom5"><br>
				<label for="name"><b>Enter Symptom 6</b></label>
				<input type="text" placeholder="Enter Symptom 6 " name="Symptom6" ><br>
                                <label for="name"><b>Enter Symptom 7</b></label>
				<input type="text" placeholder="Enter Symptom 7 " name="Symptom7" ><br>
                                <h4> Enter constraint <h5> (At least 1)</h5></h4>
				<label for="name"><b>Enter Constraint 1</b></label>
				<input type="text" placeholder="Enter constraint 1 " name="Constraint1"required><br>
				<label for="name"><b>Enter Constraint 2</b></label>
				<input type="text" placeholder="Enter constraint 2 " name="Constraint2" ><br>
				<label for="name"><b>Enter Constraint 3</b></label>
				<input type="text" placeholder="Enter constraint 3 " name="Constraint3" ><br>
                                <label for="name"><b>Enter Constraint 4</b></label>
				<input type="text" placeholder="Enter constraint 4 " name="Constraint4" ><br>
				<label for="name"><b>Enter Constraint 5</b></label>
				<input type="text" placeholder="Enter constraint 5 " name="Constraint5" ><br>
				<label for="name"><b>Enter Constraint 6</b></label>
				<input type="text" placeholder="Enter constraint 6 " name="Constraint6" ><br>
                                <label for="name"><b>Enter Constraint 7</b></label>
				<input type="text" placeholder="Enter constraint 7 " name="Constraint7" ><br>
                                
                             
                

                                <button type="submit">submit</button>
                                </br></br></br></br></br>

                            </div>
                    </div>
                    </form>
                </div>
            </div>
                </div>
            </div>
        </div>
    </div>

  


    <!-- bradcam_area_end  -->
    <!-- expert_doctors_area_start -->
    <!-- expert_doctors_area_end -->
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
        $(document).ready(function () {
            $('.js-example-basic-multiple').select2();
        });</script>
</body>
</html>