/**
 * Created by m1 on 17-3-2.
 */
import React from "react";
import Paper from 'material-ui/Paper';
import {List, ListItem} from 'material-ui/List';
import Divider from 'material-ui/Divider';
import CardItem from './CardItem'

const MainBody = () => (
  <div className="mainBody" style={{
    display:'flex',
    flexDirection:'column',
    flex:4,
    marginLeft:40

  }}>
{/*<Paper zDepth={2} >*/}
  <CardItem /><br/>
  <CardItem />
  {/*<CardItem style={style}/>*/}
{/*</Paper>*/}
  </div>


);
export default MainBody;
