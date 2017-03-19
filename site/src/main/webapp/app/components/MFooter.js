/**
 * Created by m1 on 17-3-2.
 */
import React from "react";
import Paper from 'material-ui/Paper';
import {grey700} from 'material-ui/styles/colors';
const style = {
  height: 50,
  width: '100%',
  background:grey700,
  textAlign: 'center',
  display: 'inline-block',
};

const MFooter = () => (

  <div style={{
    marginTop:100,
    marginBottom:20
  }}>

    <Paper style={style} zDepth={3}  >

      <p  style={{
        color:'#fafafa'
      }}>底部</p>
    </Paper>
  </div>


);
export default MFooter;
