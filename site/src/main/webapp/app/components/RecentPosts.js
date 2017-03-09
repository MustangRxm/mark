/**
 * Created by Administrator on 2017/3/5 0005.
 */
import React from "react";
import Paper from 'material-ui/Paper';
import {List, ListItem} from "material-ui/List";
import ContentInbox from 'material-ui/svg-icons/content/inbox';
import ActionGrade from 'material-ui/svg-icons/action/grade';
import ContentSend from 'material-ui/svg-icons/content/send';
import ContentDrafts from 'material-ui/svg-icons/content/drafts';
import Subheader from 'material-ui/Subheader';
import ActionInfo from 'material-ui/svg-icons/action/info';
import Divider from 'material-ui/Divider';
import RaisedButton from 'material-ui/RaisedButton';
import FlatButton from 'material-ui/FlatButton';
const styles = {
  button: {
    // margin: 12,
  }
};
const RecentPosts = () => (

  <Paper zDepth={2} >
      {/*<ListItem disabled={true} primaryText="Inbox" leftIcon={<ContentInbox />} />        <Divider/>*/}
      {/*<Subheader leftAvatar={<ActionGrade/>}>Recent chats</Subheader>        <Divider/>*/}
     <div style={{
       padding:5,
       marginLeft:5,
       display:'flex',
       alignItems:'center',
     }}><ContentInbox /><p>test title</p></div>
    <Divider/>

      <ul>
        <li> <a href="#">test 01</a></li>

        <li> <a href="#">test 01</a></li>
        <li> <a href="#">test 01</a></li>
        <li> <a href="#">test 01</a></li>
      </ul>
  </Paper>
);


export default RecentPosts;
