var hello=function (name) {
    console.log("Hello "+name);
}

var message_items=[{"id":63,"academicName":"Quetiapine","drugbankId":"DB01224","relevants":[{"id":71,"adj_p":0.1,"relevant_gene_num":9,"disease":{"id":65,"academicName":"Schizophrenia","diseaseId":"D012559","relevants":[]}},{"id":70,"adj_p":0.05,"relevant_gene_num":6,"disease":{"id":64,"academicName":"Depressive disorder","diseaseId":"D003866","relevants":[]}}]}]


var group=new Vue({
    el:'.message-list',
    data: {
        message_items:message_items
    }

})


var intro=new Vue({
    el:'.intro-content',
    data: {
        name:message_items[0].academicName
    }

})

var research=new Vue({
    el:'.research-table',
    data: {
        name:message_items[0].academicName
    }

})

