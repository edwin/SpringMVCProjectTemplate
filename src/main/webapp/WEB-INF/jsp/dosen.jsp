<%-- 
    Document   : dosen
    Created on : Nov 3, 2013, 4:25:20 AM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Test Application</title>
       
        <jsp:include page="include/header.jsp" />

    </head>

    <body>

        <jsp:include page="include/menu.jsp" />

        <div class="container">

            <h1>Dosen</h1> <br />
            <div id="dynamic">
                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered"id="example">
                    <thead>
                        <tr>
                            <th width="20%">NIK</th>
                            <th width="30%">Nama</th>
                            <th width="30%">Alamat</th>
                            <th width="20%">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td colspan="5" class="dataTables_empty">Loading data from server</td>
                        </tr>
                    </tbody>                    
                </table>
            </div>


        </div> <!-- /container -->
        
        <div class="modal-footer">
            &copy; Testing App
        </div>

        <jsp:include page="include/footer.jsp" />

        <script type="text/javascript" charset="utf-8">
            
            $.extend( $.fn.dataTableExt.oStdClasses, {
                "sWrapper": "dataTables_wrapper form-inline"
            } );
            
            $(document).ready(function() {
                var myTable = $('#example').dataTable( {
                    "sDom": "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
                    "bProcessing": true,
                    "bServerSide": true,
                    "sAjaxSource": "dosen/list",
                    "sServerMethod": "POST", 
                    "sPaginationType": "full_numbers",
                    "aaSorting": [[0,'desc']],  
                    "aoColumns" : [   
                         { sWidth: '20%', 
                            "mRender": function( data, type, row ) {
                                    return '<a href="dosen/detail/'+row[0]+'">'+row[0]+'</a>';
                            },
                        "bSortable": true,
                        "aTargets": [0]}, 
                        { sWidth: '30%', "bSortable": false }, 
                        { sWidth: '30%', "bSortable": false },
                        {sWidth: '20%', 
                            "mRender": function( data, type, row ) {
                                    return '<a href="dosen/delete/'+row[0]+'">Delete</a>';
                            },
                        "bSortable": false}
                    ] 
                } );	
                
                $('#example_filter input').unbind();
                $('#example_filter input').bind('keyup', function(e) {
                    if(e.keyCode == 13) {
                        myTable.fnFilter(this.value);   
                    }
                });
                
            } );
        </script>

    </body>
</html>
