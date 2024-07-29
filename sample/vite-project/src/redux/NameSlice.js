import { createSlice } from '@reduxjs/toolkit';

const NameSlice = createSlice({
  name: 'name',
  initialState: '',
  reducers: {
    setName: (state, action) => action.payload,
  },
});

export const { setName } = NameSlice.actions;
export default NameSlice.reducer;

// //Login
// const dispatch = useDispatch();
// //inside condition
// dispatch(setName(name));