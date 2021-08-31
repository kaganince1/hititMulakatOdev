var buttondelete;

$(document).ready(function() {
    buttondelete = $(".deleteButton");
    var id = 0;
    $("#mytable").on('click','.deleteButton',function(){
         var currentRow=$(this).closest("tr");
         id=currentRow.find("td:eq(0)").text();
         var contextPath = window.location.href.match(/^.*\//);
         url = contextPath + "delete-tree/" + id;
         deleteTree(url);
         currentRow.remove();
    });
});
function deleteTree(url) {
    $.get(url).done(function() {});
}