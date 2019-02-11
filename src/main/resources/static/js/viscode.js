var nodes_data=[
    {id: 1, label: 'Node 1',group:'drug'},
    {id: 2, label: 'Node 2',group:'drug'},
    {id: 3, label: 'Node 3',group:'drug'},
    {id: 4, label: 'Node 4',group:'disease'},
    {id: 5, label: 'Node 5',group:'disease'}
];
var edges_data=[
    {from: 1, to: 3},
    {from: 1, to: 2},
    {from: 2, to: 4},
    {from: 2, to: 5},
    {from: 3, to: 3}
];
// create a network
var container = document.getElementById('mynetwork');

// create an array with nodes
var nodes = new vis.DataSet(nodes_data);

// create an array with edges
var edges = new vis.DataSet(edges_data);

var data = {
    nodes: nodes,
    edges: edges
};

var options = {
     groups: {
        drug: {
            color:{
                background:'#00FF7F',
                highlight: {//节点选中时状态颜色
                    background: '#3CB371'
                },
                hover: {//节点鼠标滑过时状态颜色
                    background: '#7FFFD4'
                }
            }, 
            borderWidth:1
        },
        disease:{
            color:{
                background:'#6495ED',
                highlight: {//节点选中时状态颜色
                    background: '#00008B'
                },
                hover: {//节点鼠标滑过时状态颜色
                    background: '#87CEFA'
                }
            }, 
            borderWidth:1
        }
      },
     nodes:{//节点配置
         shape: 'dot',
         borderWidth: 1,//节点边框的宽度,单位为px
         borderWidthSelected: 2,//节点被选中时边框的宽度，单位为px
         color: {
              border: '#2B7CE9',//节点边框颜色
              background: '#DAA520',//节点背景颜色
              highlight: {//节点选中时状态颜色
                border: '#2B7CE9',
                background: '#FF8C00'
              },
              
              hover: {//节点鼠标滑过时状态颜色
                border: '#2B7CE9',
                background: '#D2E5FF'
              }
            },
            font: {//字体配置
                  color: '#FFFAFA',//颜色
                  size: 14, // 大小，单位px
                  face: 'arial',//字体
                  background: 'none',//背景
                  align: 'center',//位置left right center
              },
         shadow:true
     },
     interaction: {
         dragNodes:true,//是否能拖动节点
         dragView:false,//是否能拖动画布
         hideEdgesOnDrag:false,//拖动画布时是否隐藏连接线
         hideNodesOnDrag:false,//拖动画布时是否隐藏节点
         hover: true,//鼠标移过后加粗该节点和连接线
         keyboard:true,//
         multiselect:true,//按 ctrl 多选
         navigationButtons:true,//是否显示控制按钮
         selectable:true,//是否可以点击选择
         selectConnectedEdges:false,//选择节点后是否显示连接线
         hoverConnectedEdges:false,//鼠标滑动节点后是否显示连接线
         tooltipDelay:200,
         zoomView:true//是否能缩放画布
     },
    edges:{
            arrows: {
                to: {enabled: true, scaleFactor: 1, type: 'arrow'},
            },
            shadow:true
        }
};

//refresh var data
var refresh_data=function () {
    vis.DataSet.clear;
    network.destroy();
    var new_data = {
        nodes: new vis.DataSet(nodes_data),
        edges: new vis.DataSet(edges_data)
    };
    new vis.Network(container, new_data, options);
}

var refresh_source_drug=function () {
    var new_nodes=[];
    var new_edges=[]
    var util=group.message_items;
    new_nodes.push({id: util.id, label: util.academicName, group:'drug'});
    for (j=0;j<util.relevants.length;j++){
        new_nodes.push({id:util.relevants[j].disease.id,label:util.relevants[j].disease.academicName, group:'disease'});
        
        new_edges.push({from: util.id, to:util.relevants[j].disease.id });
        
    }
    nodes_data=new_nodes;
    edges_data=new_edges;
}


var refresh_drug=function () {
    refresh_source_drug();
    refresh_data();

}


var refresh_source_disease=function () {
    var new_nodes=[];
    var new_edges=[]
    var util=group.message_items;
    new_nodes.push({id: util.id, label: util.academicName, group:'disease'});
    for (j=0;j<util.relevants.length;j++){
        new_nodes.push({id:util.relevants[j].drug.id,label:util.relevants[j].drug.academicName, group:'drug'});
        
        new_edges.push({from:util.relevants[j].drug.id , to:util.id });
        
    }
    nodes_data=new_nodes;
    edges_data=new_edges;
}

var refresh_disease=function () {
    refresh_source_disease();
    refresh_data();

}

var network = new vis.Network(container, data, options);