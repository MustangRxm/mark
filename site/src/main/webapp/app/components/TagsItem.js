/**
 * Created by Administrator on 2017/3/10 0010.
 */
import React from "react";
import Chip from 'material-ui/Chip';
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import ContentInbox from 'material-ui/svg-icons/content/inbox';
function handleTouchTap(){

}
const TagsItem = () => (

      <Chip style={{
        margin:5
      }} onTouchTap={handleTouchTap} >163254</Chip>
);
export default TagsItem;
