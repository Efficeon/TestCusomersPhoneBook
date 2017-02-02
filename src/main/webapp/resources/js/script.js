function tableToJSON(){
    var container = new Object();
    container.list = [];
    var list;

    for(i = 0; i <document.getElementById("table").rows.length-1; i++) {
        var client = {"id": document.getElementById("list"+i+".id").value,
                      "phoneNumber": {
                          "id": document.getElementById("list"+i+".phoneNumber.id").value,
                          "number": document.getElementById("list"+i+".phoneNumber.number").value,
                          "type": document.getElementById("list"+i+".phoneNumber.type").value,
                          "description": document.getElementById("list"+i+".phoneNumber.description").value
                      },
                      "name": document.getElementById("list"+i+".name").value
                      };
        container.list.push(client);
    }
    return JSON.stringify(container);
    };

function searchAjax() {
    console.log(table);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/",
        data : tableToJSON(),
        timeout : 100000,
        success : function(data) {
            $(function(){
                for(i = 0; i<=data.list.length; i++){
                    console.log(data.list[i]);
                    document.getElementById("list"+i+".name").value = data.list[i].name;
                    document.getElementById("list"+i+".id").value = data.list[i].id;
                    document.getElementById("list"+i+".phoneNumber.number").value = data.list[i].phoneNumber.number;
                    document.getElementById("list"+i+".phoneNumber.type").value = data.list[i].phoneNumber.type;
                    document.getElementById("list"+i+".phoneNumber.description").value = data.list[i].phoneNumber.description;
                    document.getElementById("list"+i+".phoneNumber.id").value = data.list[i].phoneNumber.id;
                    i++;
                };
            });
        },
        error : function(e) {
            console.log("Exception: ", e);
        },
        done : function(e) {
        }
    });
}