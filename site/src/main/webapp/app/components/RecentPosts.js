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
const RecentPosts = () => (
  <Paper zDepth={2}>
    <div style={{
      padding: 5,
      marginLeft: 5,
      display: 'flex',
      alignItems: 'center',
    }}><FontIcon className="material-icons md-light  md-48" style={iconStyles}>border_color</FontIcon>
      <p> <b>Recent
      Posts</b></p></div>
    <Divider/>

    <ul>
      <li><a href="#">test 01</a></li>

      <li><a href="#">test 01</a></li>
      <li><a href="#">test 01</a></li>
      <li><a href="#">test 01</a></li>
    </ul>
  </Paper>
);


export default RecentPosts;
