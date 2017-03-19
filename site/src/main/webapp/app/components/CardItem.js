/**
 * Created by m1 on 17-3-2.
 */
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import React from "react";
import FontIcon from 'material-ui/FontIcon';
import '../css/IconStyle.css';
import {indigo100,grey700} from 'material-ui/styles/colors';
import Chip from 'material-ui/Chip';
// const subTitle = ()=>(
//   <div>
//     <a href="#">test</a>
//   </div>
// );


const iconStyles = {
  // marginRight: 24,

  fontSize: '18px'
};
const style = {
  display: 'flex',
  alignItems: 'center',
  marginRight: 10
};
const tagStyle = {
  display: 'flex',
  alignItems: 'center',
  marginRight: 10,
  height: 14
};
const tagFontStyle={
  color:'#ffffff'
};
const SubTitle = React.createClass({
  render: function () {
    return <div>
      <div style={style}>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>date_range</FontIcon>
          <p>2017-03-12</p>
        </div>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>account_circle</FontIcon>
          <p>account people</p>
        </div>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>view_list</FontIcon>
          <p>mycategory</p>
        </div>
      </div>
      <div style={style}>
        <FontIcon className="material-icons md-light  md-48" style={{
          fontSize: '18px',
          marginRight:5
        }}>label</FontIcon>
        <Chip backgroundColor={indigo100} style={tagStyle
        }><p style={tagFontStyle}>66666</p></Chip>
        <Chip backgroundColor={indigo100} style={tagStyle
        }><p style={tagFontStyle}>66666</p></Chip>
      </div>
    </div>
      ;
  }
});
const CardItem = () => (
  <Card>
    <CardTitle title="Card title" subtitle={<SubTitle/>}/>

    <CardText>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Donec mattis pretium massa. Aliquam erat volutpat. Nulla facilisi.
      Donec vulputate interdum sollicitudin. Nunc lacinia auctor quam sed pellentesque.
      Aliquam dui mauris, mattis quis lacus id, pellentesque lobortis odio.
    </CardText>

    <CardActions style={{
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'flex-end'
    }}>

      <FlatButton icon={<FontIcon className="material-icons md-light  md-48" style={iconStyles}>
        library_books</FontIcon>} label="Read All" style={{color:grey700}}/>
    </CardActions>
  </Card>


);


export default CardItem;
