import { Button, FormControl, Grid, TextField, Typography } from "@mui/material";
import { useState } from "react";
import iRequest from "@/interfaces/iRequest";

function RequestPage() {
  const [requestForm, setRequestForm] = useState<iRequest>({
    companyName: "",
    purpose: "",
    phoneNumber: "",
    estimation: "",
    email: "",
    file: "",
    description: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setRequestForm({
      ...requestForm,
      [name]: value,
    });
  };

  const handleClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    console.log(requestForm);
  };

  return (
    <div>
      <Typography variant="h4" align="center" gutterBottom>
        REQUEST
      </Typography>

      <Grid container spacing={2} onChange={handleChange}>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="companyName"
              value={requestForm.companyName}
              label="업체명"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="purpose"
              value={requestForm.purpose}
              label="목적"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="phoneNumber"
              value={requestForm.phoneNumber}
              label="연락처"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="estimation"
              value={requestForm.estimation}
              label="예상견적"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="email"
              value={requestForm.email}
              label="이메일"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} md={6} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="file"
              value={requestForm.file}
              type="file"
              variant="outlined"
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} item={true}>
          <FormControl fullWidth>
            <TextField
              id="outlined-basic"
              name="description"
              value={requestForm.description}
              label="내용"
              variant="outlined"
              rows={5}
              multiline
              required
            />
          </FormControl>
        </Grid>
        <Grid xs={12} item={true} textAlign="end">
          <Button variant="contained" onClick={handleClick}>
            요청
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}

export default RequestPage;
