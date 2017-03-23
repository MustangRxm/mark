/**
 * Created by Administrator on 2017/3/5 0005.
 */
import React from "react";
import Paper from "material-ui/Paper";
import {List, ListItem} from "material-ui/List";
import Divider from "material-ui/Divider";
import FontIcon from "material-ui/FontIcon";
const styles = {
  button: {
    // margin: 12,
  }
};
const iconStyles = {
  // marginRight: 24,
  fontSize:'18px'
};
// const RecentPosts = () => (
//
// );

const RecentPosts = React.createClass({
  getInitialState: function () {
    return {
      dataList: []
    };
  },
  componentWillMount:function () {
    this.setState({
      dataList:[
        {title:'i am title1',url:'www.baidu.com'},
        {title:'i am title12',url:'www.baidu2.com'},
        {title:'i am title13',url:'www.baidu3.com'},
      ]
    });
    // console.log(this.state.dataList);
  },

  render:function () {
   return (
     <Paper zDepth={2}>
       <div style={{
         padding: 5,
         marginLeft: 5,
         display: 'flex',
         alignItems: 'center',
       }}><FontIcon className="material-icons md-light  md-48" style={iconStyles}>border_color</FontIcon>
         <h4>Recent
           Posts</h4></div>
       <Divider/>

       <ul>
         {this.state.dataList.map(function (data,i) {
           return <li key={i}><a href={data.url}>{data.title}</a></li>
         })}
         {/*<li><a href="#">test 01</a></li>*/}

         {/*<li><a href="#">test 01</a></li>*/}
         {/*<li><a href="#">test 01</a></li>*/}
         {/*<li><a href="#">test 01</a></li>*/}
       </ul>
     </Paper>
   );
  }
});

export default RecentPosts;
