/**
 * Created by m1 on 17-3-2.
 */
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import React from "react";
import FontIcon from 'material-ui/FontIcon';
import '../css/IconStyle.css';
// const subTitle = ()=>(
//   <div>
//     <a href="#">test</a>
//   </div>
// );


const iconStyles = {
  // marginRight: 24,

  fontSize:'18px'
};

const SubTitle = React.createClass({
  render: function() {
    return  <div>
      <FontIcon className="material-icons  md-18" style={iconStyles}>home</FontIcon>
      <FontIcon className="material-icons md-light  md-48" style={iconStyles}>date_range</FontIcon>
      <a href="#">test</a>
    </div>;
  }
});
const CardItem = () => (
  <Card>
    <CardTitle title="Card title" subtitle={<SubTitle/>} />
    <CardText>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Donec mattis pretium massa. Aliquam erat volutpat. Nulla facilisi.
      Donec vulputate interdum sollicitudin. Nunc lacinia auctor quam sed pellentesque.
      Aliquam dui mauris, mattis quis lacus id, pellentesque lobortis odio.
    </CardText>
    <CardActions>
      <FlatButton label="Action1" />
      <FlatButton label="Action2" />
    </CardActions>
  </Card>


);


export default CardItem;
