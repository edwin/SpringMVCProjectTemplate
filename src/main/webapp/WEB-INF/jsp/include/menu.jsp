<%-- 
    Document   : menu
    Created on : Nov 3, 2013, 5:27:34 AM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Test Application</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" role="button" href="#" id="drop1"><b class="caret white-caret"></b> &nbsp;Dosen </a>
                        <ul aria-labelledby="drop1" role="menu" class="dropdown-menu">
                            <li role="presentation"><a href="${pageContext.request.contextPath}/dosen"><i class="icon-star icon-white"> </i>&nbsp;List Dosen</a></li>
                            <li class="divider"></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/dosen/new"><i class="icon-star icon-white"> </i>&nbsp;Buat Dosen</a></li>
                        </ul>
                    </li>   
                    <li><a href="mahasiswa"><i class="icon-cog icon-white"> </i>&nbsp;Mahasiswa</a></li>
                    <li><a href="kuliah"><i class="icon-road icon-white"> </i> &nbsp;Kuliah</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
